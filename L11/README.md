# Shortest Path

|                       | typical case       | worse case | restriction        |
|-----------------------|--------------------|------------|--------------------|
| Dijkstra(topological) | E(relax) + V(topo) | E + V      | no directed cycles |
| Dijkstra              | E * lg V (pq)      | E * lg V   | no negative weight |
| Bellman-Ford          | E * V              | E * V      | no negative cycles |
| Bellman-Ford(queue)   | E + V              | E * V      | no negative cycles |