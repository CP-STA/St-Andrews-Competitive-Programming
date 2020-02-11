import networkx as nx
import matplotlib.pyplot as plt

f = open("input0.txt", "r")
n = int(f.readline().split()[0])

G = nx.Graph()
G.add_nodes_from(range(0, n))

for i in range(0, n):
    line = f.readline().split()
    for j in range(0, int(line[0])):
        G.add_edge(i,int(line[j + 1]))

nx.draw_circular(G, with_labels=True)
plt.savefig("Graph.png", format="PNG")