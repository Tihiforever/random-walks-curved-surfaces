# Random Walks on Curved Surfaces

An exploration of Random Walks and how they are used and can be manipulated.

---

## Work Log

**09/02/26:** We decided that I would program a random walk 2d generator, after halftime, to discuss on a Microsoft Teams call what else can be added and done.

**10/02/26:** Created my git repository and thought about the design of it and after a short discussion with my maths teacher he suggested I learn polar coordinates and that made me think about how this project is like an ant walking on a piece of paper that is twisted in lots of different ways — as that's how random walking in a 2d shape is, as the 2d grid when in a non Euclidian form allows for different rules of shapes when a 2d plane is twisted and stretched in a 3d or a higher dimension, like how some scientists think the universe is. This allowed me to think about how I would program this.

**11/03/26:** Finished everything outlined, waiting for a response as to what to do next. I have visualised random walking on a 3d torus, but it doesn't work truly as the walker can go inside the torus, which I visualised in Desmos ([here](https://www.desmos.com/3d/j2sfzxhzr9)).

**17/03/26:** Had a discussion on Microsoft Teams explaining my work and the basics of a random walk, and how it is utilised, like in modelling gas particles in physics — taking the walker to be a particle in a gas, it moves around randomly. We also discussed how a random walk in 1D follows a binomial distribution and, after an infinite number of steps, approaches a normal distribution. After this, we discussed what to do next, where it was decided to record lots of random walkers and their distances from an origin and then plot this data relative to the number of steps taken and explore the trend and how the number of steps correlates to the distance from the origin. Then we discussed comparing this infinite plane to a bounded 2d torus and how the distance from the start changes when the walker can "loop" around, and graphing this to compare the difference.

**23/03/26:** Created a second visualisation that allowed more customisability like adding extra walkers and changing step size, along with changing the number of steps it can complete. Annoyingly, I can't upload the files, only screenshots, as this GitHub repo is set to the first prototype and idk how to change it, but I will try to fix this.

| | | |
|---|---|---|
| ![image](https://github.com/user-attachments/assets/c1bcbf98-a538-48df-b94e-eea0567dbedf) | ![image](https://github.com/user-attachments/assets/27c59b96-e5f9-4c8f-8094-127d4138f170) | ![image](https://github.com/user-attachments/assets/c1bcbf98-a538-48df-b94e-eea0567dbedf) | 


https://github.com/user-attachments/assets/a894a74e-201b-47da-bbde-043958e76675

**18/04/26:** Built a dedicated data collection simulator that could be changed for the number of steps and the number of walkers, exporting a CSV per walker with step, x, y, and distance from origin. Positions are normalised, so the origin is always (0, 0) and the step size is always 1 unit regardless of pixel size, making data from different runs directly comparable. I also started building the Python script that would visualise all of the data collected. Shown below is how long it took to simulate the largest dataset of 1000 walkers and 10000 steps. Then, an example of how the newest model looks with 100 walkers and 100 steps.

| | |
|---|---|
| ![image](https://github.com/user-attachments/assets/021205e1-d7e6-471c-9b50-6504b26c1546) | ![image](https://github.com/user-attachments/assets/ceb19982-2f55-4758-b4b1-de1d8ad539b4) |


**19/04/2026:** I used a Python script that could compile all of the data collected and generate graphs of all the data, making it easier to visualise. I also finished making the README look nice and uploading this to GitHub Pages.

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

I have discovered a love for geometry and topology, and how distances are affected on curved surfaces. This then led me to research how random walks are used in different dimensions, such as 1D, and how over an infinite number of steps or a large number of steps the walker forms a binomial distribution and then for an infinite number of steps across n distances on a 1D plane forms a normal distribution. When exploring random walking in 2D, I discovered the representation of pi as a random walk and how it changes when the length of pi changes, along with the base of pi changing and then the difference between using mod 4 and not.

| | |
|---|---|
| ![image](https://github.com/user-attachments/assets/8858199a-2968-462e-981f-6f1479e1cbf3) | ![image](https://github.com/user-attachments/assets/69ce5432-f65e-4436-9710-f09959a051a5) |
| Base: 10 · Digits: 6070 | Base: 4 · Digits: 7700 |
| ![image](https://github.com/user-attachments/assets/5eeac821-4a4a-4be1-b2df-3cb10b1e8b95) | ![image](https://github.com/user-attachments/assets/6576582c-546d-4123-a8bb-d2d31e1a132d) |
| Base: 2 · Digits: 2090 | Base: 10 · Digits: 300 |

https://github.com/user-attachments/assets/a570904e-4ef5-4def-ab40-8af0d44794f6

These examples helped me explore random walks and learn how to visualise them, which is piquing my interest in the topic further and aiding my continued exploration and comparison of random walks and topology.

---

# Results — 2D Unbounded Plane

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

The mean consistently sits slightly below √n — this is expected as distance is always positive and the distribution is right-skewed, pulling the mean below the RMS value.

---

## Average Distance vs Steps

The average distance grows as a smooth √n curve in all five runs. The blue line is the simulation data, and the dashed line is the √n reference.

| 100 steps | 500 steps |
|-----------|-----------|
| ![image](https://github.com/user-attachments/assets/69392823-8435-40cf-a1bd-cba1e75e5290) | ![image](https://github.com/user-attachments/assets/62e0d474-422b-4f32-9cb0-b8c591b647bf) |

| 1000 steps | 5000 steps | 10000 steps |
|------------|------------|-------------|
| ![](https://github.com/user-attachments/assets/541738ae-db8b-4071-b0a9-dc59272c5413") | ![]("https://github.com/user-attachments/assets/47f6c7af-624f-4ff1-8097-e6086677e66d") | ![]("https://github.com/user-attachments/assets/7d06e99a-adf9-4ec9-be4e-b6c4e6f38ba3") |

---

## Log-Log Plots

A straight line with a gradient of 0.5 on a log-log plot is the mathematical proof of √n growth.

| 100 steps | 500 steps |
|-----------|-----------|
| ![](https://github.com/user-attachments/assets/INSERT_100_LOGLOG) | ![](https://github.com/user-attachments/assets/INSERT_500_LOGLOG) |

| 1000 steps | 5000 steps | 10000 steps |
|------------|------------|-------------|
| ![](https://github.com/user-attachments/assets/INSERT_1000_LOGLOG) | ![](https://github.com/user-attachments/assets/INSERT_5000_LOGLOG) | ![](https://github.com/user-attachments/assets/INSERT_10000_LOGLOG) |

---

## Distribution of Final Distances

The final distances follow a right-skewed distribution in all runs, with the peak shifting right as step count increases. The mean (orange) sits slightly above the median (green) in every case due to the long tail.

| 100 steps | 500 steps |
|-----------|-----------|
| ![](https://github.com/user-attachments/assets/INSERT_100_DIST) | ![](https://github.com/user-attachments/assets/INSERT_500_DIST) |

| 1000 steps | 5000 steps | 10000 steps |
|------------|------------|-------------|
| ![](https://github.com/user-attachments/assets/INSERT_1000_DIST) | ![](https://github.com/user-attachments/assets/INSERT_5000_DIST) | ![](https://github.com/user-attachments/assets/INSERT_10000_DIST) |

---

## Final Position Heatmaps

The density of final positions forms a radially symmetric blob centred on the origin. The dotted white circle marks the expected RMS distance √n — the high-density region sits inside this circle in every run, visually confirming the √n relationship.

| 100 steps | 500 steps |
|-----------|-----------|
| ![](https://github.com/user-attachments/assets/INSERT_100_HEAT) | ![](https://github.com/user-attachments/assets/INSERT_500_HEAT) |

| 1000 steps | 5000 steps | 10000 steps |
|------------|------------|-------------|
| ![](https://github.com/user-attachments/assets/INSERT_1000_HEAT) | ![](https://github.com/user-attachments/assets/INSERT_5000_HEAT) | ![](https://github.com/user-attachments/assets/INSERT_10000_HEAT) |

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

- [Wikipedia — Random Walk](https://en.wikipedia.org/wiki/Random_walk)
- [Wikipedia — Torus](https://en.wikipedia.org/wiki/Torus)
- [Wolfram MathWorld — Torus](https://mathworld.wolfram.com/Torus.html)
- [REU Paper — Courbe](https://math.uchicago.edu/~may/REU2024/REUPapers/Courbe.pdf)
- [Wolfram Community](https://community.wolfram.com/groups/-/m/t/82377)
- [Math StackExchange — Parameterization of a Torus](https://math.stackexchange.com/questions/1578756/parameterization-of-a-torus)
- [Wired — Pi as a Random Walk](https://www.wired.com/2017/03/hey-can-find-pi-random-walk-heres/)
- [Wolfram Demonstrations — Random Walk from Digits of Pi](https://demonstrations.wolfram.com/RandomWalkGeneratedByTheDigitsOfPi/)
- [Math StackExchange — Expected Value of Random Walk](https://math.stackexchange.com/questions/103142/expected-value-of-random-walk)
