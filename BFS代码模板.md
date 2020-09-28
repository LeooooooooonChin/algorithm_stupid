```python
# Python
def BFS(graph, start, end):
    visited = set()
    queue = []
    queue.append([start])
    while queue:
        node = queue.pop()
        visited.add(node)
        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
    # other processing work
    ...
```

``` java
public void bfs() {
    Set visited = new HashSet<>();
    
}
```
