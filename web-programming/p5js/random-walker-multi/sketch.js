/*
  Originally by: Daniel Shiffman
  Modified by: Tyler Bartnick
  Date: 12/10/2018

  Random walker implemented with p5.js, using Levy Flights.
*/

var walkers;

// light version
// var colors = [
//   [73, 30, 232],
//   [232, 54, 30],
//   [232, 153, 30],
//   [30, 232, 33],
//   [232, 30, 63]
// ];

// dark version
var colors = [
  [237, 205, 168],
  [168, 237, 229],
  [170, 237, 168],
  [212, 252, 115],
  [245, 227, 82]
];

function RandomWalker(x, y, color, weight) {
  this.pos    = createVector(x, y); // current position
  this.prev   = this.pos.copy();    // previous position
  this.color  = color;
  this.weight = weight;             // stroke weight
}

function setup() {
  // background(255);
  
  createCanvas(1000, 800);
  colorMode(RGB);
  background(41);

  walkers = [];
  for (var i = 0; i < 25; i++) {
    walkers.push(new RandomWalker(random(300, 700), random(300, 500), colors[Math.floor(random(0, 5))], Math.floor(random(1, 4))));
  }
}

function draw() {
  walkers.forEach((walker) => {
    stroke(walker.color[0], walker.color[1], walker.color[2]);
    strokeWeight(walker.weight);
    line(walker.pos.x, walker.pos.y, walker.prev.x, walker.prev.y);
    walker.prev.set(walker.pos);

    var step = p5.Vector.random2D();
    var r = random(100);
    if (r < 1) {
      step.mult(random(25, 100));
    } else {
      step.setMag(2);
    }

    walker.pos.add(step);
  });
}
