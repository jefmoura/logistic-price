# Logistic Price

When we have a network of nodes and want to ship a package from a node to any other one at the optimal (lowest) cost, we need to find out the shortest path between them. Therefore, to solve this problem we need to consider, for example, the difficulty of shipping a package between the nodes. Considering that exists only positive weight between nodes, to solve this problem, we use the Dijkstra's Algorithm. To calc the shipment of a package with a certain weight and dimensions at a fixed cost, we use the following formula:

`
shipping cost (EUR) = sqrt(sum(HARD)) * normalized weight (kg)
`

A normalized package weight is the greater value of an actual weight or a volumetric weight. A volumetric weight is calculated using the following formula rounding up to the nearest 0,5:

`
Width x Length x Height (cm) / 5000 = Volumetric Weight (kg)
`

### Compile

As it's a Java program we can compile it using your favorite IDE or a command line. This is a simple and easy way to compile the program:

`
$machine: javac logistic-price/*.java
`

Afterwards, we'll have the program ready to be used.

### Execute

To execute the program we have to follow some steps. First, you have to have a file with a network representation and it has to follow this structure:

```
SOURCE,TARGET:WEIGHT,TARGET:WEIGHT ...
SOURCE,TARGET:WEIGHT,TARGET:WEIGHT ...
```

**SOURCE​** is the node which has its relations described in the line;
**TARGET** ​ is a node that the ​ *SOURCE​* is connected;
**WEIGHT** is the hardness relationship between the ​ *SOURCE​* and ​ *TARGET​* ;
You can see an example below:

```
ME,Lisa:33,Marco:123,Bruno:55
Lisa,Bruno:3
Rachel,Marco:11
```

Finally, to execute the program you can use the following command:

`
$machine: java -Xmx100m logistic.price.main.Snippet file_name origin_name
target_name package_info
`

**file_name​** : the name of the file that has the graph represented;
**origin_name​** : the name of the origin node from where we want to calc the lowest shipping cost;
**target_name​** : the name of the target node to where we want to calc the lowest shipping cost;
**package_info​** : the information about the package that we want to ship. Width(cm), Length(cm), Height(cm), Weight(g). This one we have to use the following format:

`
Width x Length x Height x Weight , for example, 26x10x5x400
`