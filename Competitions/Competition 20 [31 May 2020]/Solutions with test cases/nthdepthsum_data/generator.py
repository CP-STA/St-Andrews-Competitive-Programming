# Test case generator for Q2, makes directed acyclic graphs.
# Taken and adapted from the generator used for Question 2 in Contest 9 by Kanishk Ali Khanna: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-9/

import collections
import random
from random import seed
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
 
    num_test_cases = 50

    stations = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"]

    max_station_index = 300

    max_num_routes = 300

    test_case_count = 0

    max_total_ways, file_number = 0, -1

    bounds = []

    while test_case_count < num_test_cases:
        randcrack = random.randint(1, max_num_routes)
        source = str(randcrack)
        destination = str(random.randint(1, max_num_routes))
        num_routes = random.randint(1, max_num_routes)
        j = 0
        routes = []
        set_routes = set(routes)
        while j < num_routes:
            randIndex1 = random.randint(0, num_routes - 1)
            randIndex2 = random.randint(0, num_routes - 1)

            # ensuring origin and destination are different
            while randIndex1 == randIndex2:
                randIndex2 = random.randint(0, num_routes)

            poss_route = str(randIndex1) + " " + str(randIndex2)
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
        if 1 < num_unique_routes < pow(2, 32):

            test_case_count += 1

            input_file = open("input/" + "input" + str(test_case_count) + ".txt", 'w')
            output_file = open("output/" + "output" + str(test_case_count) + ".txt", 'w')

            input_file.write(str(len(routes)) + "\n")
            for route in routes:
                input_file.write(route + '\n')
            input_file.write(str(randcrack) + "\n") # randomiser, root number
            input_file.write(str(random.randint(0,15)) + "\n") # depth number
            for way in ways_to_destination:
                output_file.write(way + "\n")

            if max_total_ways < num_unique_routes:
                max_total_ways = num_unique_routes
                file_number = test_case_count

    print(max_total_ways, file_number)


test_case_generator()
