# Random Walks on Curved Surfaces

An exploration of Random Walks and how they are used and can be manipulated.

---

## Work Log

**09/02/26:** We decided that I would program a random walk 2D generator, after halfterm to discuss on a Microsoft Teams call what else can be added and done.

**10/02/26:** Created my git repository and thought about the design of it and after a short discussion with my maths teacher he suggested I learn polar coordinates and that made me think about how this project is like an ant walking on a piece of paper that is twisted in lots of different ways, as that's how random walking in a 2D shape is, as the 2D grid when in a non-Euclidean form allows for different rules of shapes when a 2D plane is twisted and stretched in a 3D or higher dimension, like how some scientists think the universe is. This allowed me to think about how I would program this.

**11/03/26:** Finished everything outlined, waiting for a response as to what to do next. I have visualised random walking on a 3D torus, but it doesn't work truly as the walker can go inside the torus, which I visualised in Desmos ([here](https://www.desmos.com/3d/j2sfzxhzr9)).

**17/03/26:** Had a discussion on Microsoft Teams explaining my work and the basics of a random walk, and how it is utilised, like in modelling gas particles in physics, taking the walker to be a particle in a gas, it moves around randomly. We also discussed how a random walk in 1D follows a binomial distribution and, after an infinite number of steps, approaches a normal distribution. After this, we discussed what to do next, where it was decided to record lots of random walkers and their distances from an origin and then plot this data relative to the number of steps taken and explore the trend and how the number of steps correlates to the distance from the origin. Then we discussed comparing this infinite plane to a bounded 2D torus and how the distance from the start changes when the walker can "loop" around, and graphing this to compare the difference.

**23/03/26:** Created a second visualisation that allowed more customisability like adding extra walkers and changing step size, along with changing the number of steps it can complete. Annoyingly, I can't upload the files, only screenshots, as this GitHub repo is set to the first prototype and idk how to change it, but I will try to fix this.

| | |
|---|---|
| ![image](https://github.com/user-attachments/assets/c1bcbf98-a538-48df-b94e-eea0567dbedf) | ![image](https://github.com/user-attachments/assets/27c59b96-e5f9-4c8f-8094-127d4138f170) |

<video src="https://github.com/user-attachments/assets/a894a74e-201b-47da-bbde-043958e76675" controls width="100%" muted autoplay>
</video>


**18/04/26:** Built a dedicated data collection simulator that could be configured for the number of steps and walkers, exporting a CSV per walker with step, x, y, and distance from origin. Positions are normalised so the origin is always (0, 0) and step size is always 1 unit regardless of pixel size, making data from different runs directly comparable. Also started building the Python script to visualise all collected data. Shown below is the 1000 walker, 10000 step simulation completing, and an example of the newer visualiser with 100 walkers and 100 steps.

| | |
|---|---|
| ![image](https://github.com/user-attachments/assets/021205e1-d7e6-471c-9b50-6504b26c1546) | ![image](https://github.com/user-attachments/assets/ceb19982-2f55-4758-b4b1-de1d8ad539b4) |

<video src="https://github.com/user-attachments/assets/c6406bc6-54a2-444c-830b-aaab9d1bed41" controls width="100%" muted autoplay>
</video>


**19/04/26:** Used a Python script to compile all collected data and generate graphs, making it easier to visualise. Finished making the README look nice and uploaded everything to GitHub Pages.

---

## To-Do

- [x] Build a random walk visualiser
- [x] Run multiple walkers simultaneously
- [x] Record distance from origin and write to CSV
- [x] Allow unbounded random walk
- [x] Graph data from CSV files — average distance vs steps, heatmaps
- [x] Build bounded torus mode and compare to unbounded plane
- [ ] Vary torus size and compare results
- [ ] Explore regular tilings (square, triangular, hexagonal)
- [ ] Explore uniform and non-uniform tilings
- [ ] Try to figure out how distances change on curved surfaces

---

## Self Exploration

I have discovered a love for geometry and topology, and how distances are affected on curved surfaces. This led me to research how random walks are used in different dimensions. In 1D, over a large number of steps, the walker forms a binomial distribution, which approaches a normal distribution over an infinite number of steps.

When exploring random walking in 2D, I discovered the representation of pi as a random walk and how it changes when the length of pi changes, the base of pi changes, and the difference between using mod 4 and not.

| | |
|---|---|
| ![image](https://github.com/user-attachments/assets/8858199a-2968-462e-981f-6f1479e1cbf3) | ![image](https://github.com/user-attachments/assets/69ce5432-f65e-4436-9710-f09959a051a5) |
| Base: 10 · Digits: 6070 | Base: 4 · Digits: 7700 |
| ![image](https://github.com/user-attachments/assets/5eeac821-4a4a-4be1-b2df-3cb10b1e8b95) | ![image](https://github.com/user-attachments/assets/6576582c-546d-4123-a8bb-d2d31e1a132d) |
| Base: 2 · Digits: 2090 | Base: 10 · Digits: 300 |

<video src="https://github.com/user-attachments/assets/a570904e-4ef5-4def-ab40-8af0d44794f6" controls width="100%" muted autoplay>
</video>


Thinking about what different surfaces a random walker could move on led me naturally into geometry. A classic football is a great example of this, as it's covered by pentagons and hexagons stitched together, which is actually a truncated icosahedron, one of the 13 [Archimedean solids](https://en.wikipedia.org/wiki/Archimedean_solid). Archimedean solids are convex polyhedra whose faces are regular polygons and whose vertices are all identical. In 3D, the football's surface is a finite tiling of two polygon types. This made me think about what happens when you flatten that idea out onto an infinite plane.

This led me to [Euclidean tilings by convex regular polygons](https://en.wikipedia.org/wiki/Euclidean_tilings_by_convex_regular_polygons). There are only 3 regular tilings of the plane (where every tile is the same regular polygon): the triangular (3⁶), square (4⁴), and hexagonal (6³) tilings. Beyond those, there are 8 semiregular or Archimedean tilings which use two or more types of regular polygons, but with every vertex identical. The hexagonal tiling is particularly interesting because it is the most efficient way to divide a plane into equal areas with the least perimeter, which is why honeycombs use it. A random walker on a triangular tiling has 6 neighbours at each vertex, on a square tiling has 4, and on a hexagonal tiling has only 3, and that difference in vertex degree directly changes how quickly the walker can spread out, which is exactly what this project investigates.

From tilings, I then discovered [tessellations](https://en.wikipedia.org/wiki/Tessellation) more broadly, the covering of a surface using one or more geometric shapes with no gaps or overlaps. Tessellations extend far beyond regular polygons into aperiodic tilings like Penrose tilings, which never repeat but still fill the plane perfectly, and into hyperbolic geometry where the rules of Euclidean space no longer apply. This opened up the question of what a random walk looks like on a non-repeating or hyperbolic surface, which feeds directly into the later stages of this project.

---

# Results - 2D Unbounded Plane

> 1000 walkers simulated on a 2D square lattice across five runs, recording average distance from origin, distribution of final positions, and final position density at each step count.

---

## Log-Log Gradients

| Steps | Gradient | Theory | R² |
|-------|----------|--------|----|
| 100 | 0.4992 | 0.5000 | 0.99903 |
| 500 | 0.4908 | 0.5000 | 0.99955 |
| 1000 | 0.5073 | 0.5000 | 0.99943 |
| 5000 | 0.4941 | 0.5000 | 0.99965 |
| 10000 | 0.5108 | 0.5000 | 0.99967 |

All gradients are within 2% of the theoretical value of **0.5**, with R² > 0.999 in every case, confirming the √n relationship.

---

## Mean Final Distance vs √n

| Steps (n) | Mean final distance | √n (theory) | % error |
|-----------|-------------------|-------------|---------|
| 100 | 9.02 | 10.00 | 9.8% |
| 500 | 19.42 | 22.36 | 13.1% |
| 1000 | 28.46 | 31.62 | 10.0% |
| 5000 | 61.65 | 70.71 | 12.8% |
| 10000 | 91.17 | 100.00 | 8.8% |

The mean consistently sits slightly below √n, this is expected as distance is always positive and the distribution is right-skewed, pulling the mean below the RMS value.

---

## Overall Data Summary

The three plots below show all five runs together. The combined line graph shows every run following the same √n curve regardless of step count. The two scatter plots show the average distance per run with ±1 standard deviation error bars, with the first using only the final step distance and the second averaging across all steps.

| Combined line — all runs | Average final distance per run |
|--------------------------|-------------------------------|
| ![image]("https://github.com/user-attachments/assets/a0358a61-bf64-4977-86bc-6e4c02df8235") | ![image]("https://github.com/user-attachments/assets/8ab04178-9083-4380-92b1-a6878adb4c52") |

| Average distance across all steps per run |
|------------------------------------------|
| ![image]("https://github.com/user-attachments/assets/dd0291b7-0255-4a6a-9278-6f9670cab144") |

---

## Average Distance vs Steps

The average distance grows as a smooth √n curve in all five runs. The blue line is the simulation data and the dashed line is the √n reference.

| 100 steps | 500 steps |
|-----------|-----------|
| ![image](https://github.com/user-attachments/assets/69392823-8435-40cf-a1bd-cba1e75e5290) | ![image](https://github.com/user-attachments/assets/62e0d474-422b-4f32-9cb0-b8c591b647bf) |

| 1000 steps | 5000 steps | 10000 steps |
|------------|------------|-------------|
| ![image](https://github.com/user-attachments/assets/541738ae-db8b-4071-b0a9-dc59272c5413) | ![image](https://github.com/user-attachments/assets/47f6c7af-624f-4ff1-8097-e6086677e66d) | ![image](https://github.com/user-attachments/assets/7d06e99a-adf9-4ec9-be4e-b6c4e6f38ba3) |

---

## Log-Log Plots

A straight line with a gradient of 0.5 on a log-log plot is the mathematical proof of √n growth.

| 100 steps | 500 steps |
|-----------|-----------|
| ![image](https://github.com/user-attachments/assets/9a651942-d1f4-4af7-918b-0aa223be16eb) | ![image](https://github.com/user-attachments/assets/560606ee-a11a-4c85-bd02-ae03fcab2308) |

| 1000 steps | 5000 steps | 10000 steps |
|------------|------------|-------------|
| ![image](https://github.com/user-attachments/assets/67249730-5c0b-40af-8069-dcf8856b824e) | ![image](https://github.com/user-attachments/assets/a7147b2a-f160-46ba-a573-3b25a91de88d) | ![image](https://github.com/user-attachments/assets/3d8d1e66-b003-47f1-8fc3-cab28efe4df8) |

---

## Distribution of Final Distances

The final distances follow a right-skewed distribution in all runs, with the peak shifting right as step count increases. The mean (orange) sits slightly above the median (green) in every case due to the long tail.

| 100 steps | 500 steps |
|-----------|-----------|
| ![image](https://github.com/user-attachments/assets/d9a72f8e-5f88-4d83-8690-fe6011a9931c) | ![image](https://github.com/user-attachments/assets/072a0576-a6f5-49fd-a4da-be9ef4ed818f) |

| 1000 steps | 5000 steps | 10000 steps |
|------------|------------|-------------|
| ![image](https://github.com/user-attachments/assets/99cd7196-f687-4b0a-a26a-7201d8c84213) | ![image](https://github.com/user-attachments/assets/29aada13-3724-496d-86d9-4875ef88b30c) | ![image](https://github.com/user-attachments/assets/8bbeeb1a-8450-4451-8d78-46ec888a28f5) |

---

## Final Position Heatmaps

The density of final positions forms a symmetric blob centred on the origin. The dotted white circle marks the expected RMS distance √n, the high-density region sits inside this circle in every run, visually confirming the √n relationship.

| 100 steps | 500 steps |
|-----------|-----------|
| ![image](https://github.com/user-attachments/assets/d9dada0f-1087-4529-a7c1-e66f7d43f82b) | ![image](https://github.com/user-attachments/assets/3de8755d-29b7-4d79-acd8-55d49e6d50b0) |

| 1000 steps | 5000 steps | 10000 steps |
|------------|------------|-------------|
| ![image](https://github.com/user-attachments/assets/2fbc3f26-231f-45db-8653-d9547e8ef1d6) | ![image](https://github.com/user-attachments/assets/5af32c77-e565-44b4-a55b-ecb3610e1734) | ![image](https://github.com/user-attachments/assets/311b0df7-da3b-4a2d-9b2f-2d649037ad2c) |

---

## Key Result

On an unbounded 2D plane, the average distance from the origin grows proportional to **√n** regardless of the number of steps taken. This is confirmed by:
- Log-log gradients all within 2% of 0.5
- R² > 0.999 across all runs
- Radially symmetric final position density with spread matching √n
- Right-skewed final distance distribution with mean tracking √n

This serves as the **baseline** for comparison against the bounded 2D torus, where the wrapping geometry is expected to cause the distance to plateau rather than grow indefinitely.

---

## Sources

- [Wikipedia - Random Walk](https://en.wikipedia.org/wiki/Random_walk)
- [Wikipedia - Torus](https://en.wikipedia.org/wiki/Torus)
- [Wikipedia - Euclidean Tilings by Convex Regular Polygons](https://en.wikipedia.org/wiki/Euclidean_tilings_by_convex_regular_polygons)
- [Wikipedia - Archimedean Solid](https://en.wikipedia.org/wiki/Archimedean_solid)
- [Wikipedia - Tessellation](https://en.wikipedia.org/wiki/Tessellation)
- [Wolfram MathWorld - Torus](https://mathworld.wolfram.com/Torus.html)
- [Wolfram MathWorld - Tessellation](https://mathworld.wolfram.com/Tessellation.html)
- [Wolfram MathWorld - Semiregular Tessellation](https://mathworld.wolfram.com/SemiregularTessellation.html)
- [REU Paper - Courbe](https://math.uchicago.edu/~may/REU2024/REUPapers/Courbe.pdf)
- [Wolfram Community](https://community.wolfram.com/groups/-/m/t/82377)
- [Math StackExchange - Parameterisation of a Torus](https://math.stackexchange.com/questions/1578756/parameterization-of-a-torus)
- [Math StackExchange - Expected Value of Random Walk](https://math.stackexchange.com/questions/103142/expected-value-of-random-walk)
- [Wired — Pi as a Random Walk](https://www.wired.com/2017/03/hey-can-find-pi-random-walk-heres/)
- [Wolfram Demonstrations — Random Walk from Digits of Pi](https://demonstrations.wolfram.com/RandomWalkGeneratedByTheDigitsOfPi/)
- [Grünbaum & Shephard — Tilings by Regular Polygons (1977)](https://doi.org/10.2307/2689529)
