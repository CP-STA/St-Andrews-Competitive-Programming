import collections
import random

all_nodes = set()


# This function will return a graph which converts the routes array that has been passed into an
# adjacency list, it will also keep a track of all the nodes in the graph
def generate_graph(routes):
    graph = collections.defaultdict(list)
    for route in routes:
        source, destination = route.split()
        graph[source].append(destination)
        all_nodes.add(source)
        all_nodes.add(destination)

    return graph


# dfs traversal solution, function will be called repeatedly until destination is discovered and then backtrack
# algorithm derived from https://leetcode.com/problems/all-paths-from-source-to-target/solution/
def calculate_unique_paths(graph, source, destination):
    def solve(node):
        # if condition is met algorithm will backtrack
        if node == destination: return [destination]
        ans = []
        for nei in graph[node]:
            #  now exploring neighbours of node the path has been called at
            #  the answer is {node} + {path from nei to destination}
            for path in solve(nei):
                ans.append(str(node) + "->" + str(path))
        return ans

    # returning a sorted list of paths, that are not repeated
    return sorted(list(set(solve(source))))


# https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
def isCyclicUtil(graph, v, visited, recStack):
    # Mark current node as visited and
    # adds to recursion stack
    visited[v] = True
    recStack[v] = True

    # Recur for all neighbours
    # if any neighbour is visited and in
    # recStack then graph is cyclic
    for neighbour in graph[v]:
        if not visited[neighbour]:
            if isCyclicUtil(graph, neighbour, visited, recStack):
                return True
        elif recStack[neighbour]:
            return True

    # The node needs to be poped from
    # recursion stack before function ends
    recStack[v] = False
    return False

    # Returns true if graph is cyclic else false


def isCyclic(graph):
    visited = {node: False for node in all_nodes}
    recStack = {node: False for node in all_nodes}
    for node in all_nodes:
        if not visited[node]:
            if isCyclicUtil(graph, node, visited, recStack):
                return True
    return False


def test_case_generator():
    source = "LEU"
    destination = "KGX"

    num_test_cases = 20

    stations = ["LEU", "EDB", "KDY", "INK", "HYM", "DUN", "BWK", "NCL", "DAR", "YRK", "SVG", "PBO", "KGX",
                "CUP", "LDY", "MNC", "SPF", "BTS", "EGY", "SGL", "KGH", "DAG", "DHM", "DON", "MPT", "ACK"]

    max_station_index = len(stations) - 1

    max_num_routes = 200

    test_case_count = 3

    max_total_ways, file_number = 0, -1

    bounds = []

    while test_case_count < num_test_cases:

        num_routes = random.randint(1, max_num_routes)

        j = 0

        routes = []
        set_routes = set(routes)
        while j < num_routes:

            randIndex1 = random.randint(0, max_station_index)
            randIndex2 = random.randint(0, max_station_index)

            # ensuring origin and destination are different
            while randIndex1 == randIndex2:
                randIndex2 = random.randint(0, max_station_index)

            poss_route = stations[randIndex1] + " " + stations[randIndex2]
            routes.append(poss_route)
            graph = generate_graph(routes)

            # ensuring graph created is not cyclic and that route hasn't been repeated
            if isCyclic(graph) or poss_route in set_routes:
                j -= 1
                routes.pop()

            set_routes.add(poss_route)

            j += 1

        graph = generate_graph(routes)
        ways_to_destination = calculate_unique_paths(graph, source, destination)
        num_unique_routes = len(ways_to_destination)

        # writing to files which will contain inputs matching with corresponding outputs
        if pow(2, 10) < num_unique_routes < pow(2, 16):

            test_case_count += 1

            input_file = open("LEU_KGX_Testcases/input/" + "input" + str(test_case_count) + ".txt", 'w')
            output_file = open("LEU_KGX_Testcases/output/" + "output" + str(test_case_count) + ".txt", 'w')

            input_file.write(str(len(routes)) + "\n")
            for route in routes:
                input_file.write(route + '\n')

            for way in ways_to_destination:
                output_file.write(way + "\n")

            if max_total_ways < num_unique_routes:
                max_total_ways = num_unique_routes
                file_number = test_case_count

    print(max_total_ways, file_number)


test_case_generator()
