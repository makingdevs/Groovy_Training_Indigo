class Point {
  int x,y

  Point plus(Point p){
    new Point(
      x: this.x + p.x,
      y: this.y + p.y)
  }

  Point minus(Point p){
    new Point(
      x: this.x - p.x,
      y: this.y - p.y)
  }
  Point multiply(scalar){
    new Point(
      x: this.x * scalar,
      y: this.y * scalar)
  }
  String toString(){ "($x, $y)" }
}

p1 = new Point(x:4, y:7)
p2 = new Point(x:5, y:6)

p3 =  p1 + p2
p4 =  p1 - p2
p5 =  p1 * 4
println p3
println p4
println p5
