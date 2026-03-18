# Random-walks-curved-surfaces
An exploration of Random Walks and how they are used and can be manipulated.

# Work Log
09/02/26: We decided that I would program a random walk 2d generator, after halfterm to discuss on a Microsoft Teams call what else can be added and done  

10/02/26: created my git repository and thought about the design of it and after a short discussion with my maths teacher he suggested I learn polar coordinates and that made me think about how this is project is like an ant walking on a piece of paper that is twisted in lots of different ways as that’s how random walking in a 2d shape is as the 2d grid when in a non Euclidian form  allows for different rules of shapes when a 2d plane is twisted and stretched in a 3d or a higher dimension like how some scientist think the universe is. This allowed me to think about how I would program this  

11/03/26: finished everything outlined, waiting for a response as to what to do next, as I have visualised random walking on a 3d torus, but it doesn’t work truly as the walker can go inside the torus wich I visualised in Desmos (here https://www.desmos.com/3d/j2sfzxhzr9)

17/03/26: Had a discussion on Microsoft Teams explaining my work and the basics of a random walk, and how it is utilised, like in modelling gas particles in phyiscs as taking the walker to be a particle in a gas, it moves around randomly. We also discussed how a random walk in 1D follows a binomial distribution and, after an infinite number of steps, approaches a normal distribution. After this, we discussed what to do next, where it was decided to record lots of random walkers and their distances from an origin and then plot this data relative to the number of steps taken and explore the trend and how the number of steps correlates to the distance from the origin. Then we discuss ed comparing this infinite plane to a bounded 2d torus and how the distance from the start changes when the walker can "loop" around and be able to graph this to compare the difference.

# To-Do:
-build another random walk:
  -that can run multiple walks with a set n amount of steps or be able to run forever and run till an input is pressed.
  -be able to record the distance from the origin and write it into a file
  -allow the random walk tp un bounded
-then graph it using the created CSV files and create heatmaps and graphs

-then do the same thing but with a bounded torus and compare to an unbounded 2d plane and different sizes of the grid of the bounded torus and compare results, more heatmaps, more graphs, more write-ups.

-after finishing all of that, try to figure out how distances change on curved surfaces and compare the distance from an orgin so the same stuff just on curved surfaces.


# Self exploration
I have discovered a love for geometry and topology, and how distances are affected on curved surfaces. This then led me to research how random walks are used in different dimensions, such as 1d, and how over a infinte number of steps or a large number of steps the walker forms a binomial distribution and then for a infinte number of steps across n distances on a 1d plane forms a normal distribution. When exploring random walking in 2D, I discovered the representation of pi as a random walk and how it changes when the length of pi changes, along with the base of pi changing and then the difference between using mod 4 and not.

E.g.


<img width="544" height="463" alt="image" src="https://github.com/user-attachments/assets/8858199a-2968-462e-981f-6f1479e1cbf3" />
Base: 10      Number of Digits: 6070

<img width="544" height="463" alt="image" src="https://github.com/user-attachments/assets/69ce5432-f65e-4436-9710-f09959a051a5" />
Base: 4      Number of Digits: 7700

<img width="544" height="463" alt="image" src="https://github.com/user-attachments/assets/5eeac821-4a4a-4be1-b2df-3cb10b1e8b95" />
Base: 2     Number of Digits: 2090

<img width="544" height="463" alt="image" src="https://github.com/user-attachments/assets/6576582c-546d-4123-a8bb-d2d31e1a132d" />
Base: 10    Number of Digits: 300


https://github.com/user-attachments/assets/a570904e-4ef5-4def-ab40-8af0d44794f6


These examples helped me explore random walks and learn how to visualise them, which is piquing my interest in the topic further and aiding me in my continued exploration and comparsion of random walks and topology.

# Sources
https://en.wikipedia.org/wiki/Random_walk
https://en.wikipedia.org/wiki/Torus
https://mathworld.wolfram.com/Torus.html
https://math.uchicago.edu/~may/REU2024/REUPapers/Courbe.pdf
https://community.wolfram.com/groups/-/m/t/82377
https://math.stackexchange.com/questions/1578756/parameterization-of-a-torus
https://www.wired.com/2017/03/hey-can-find-pi-random-walk-heres/
https://demonstrations.wolfram.com/RandomWalkGeneratedByTheDigitsOfPi/
https://math.stackexchange.com/questions/103142/expected-value-of-random-walk
