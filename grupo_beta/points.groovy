class Point {
  int x
  int y
  //Point plus(Point other){
  //  new Point(x:this.x + other.x,y: this.y + other.y )
  //}
  String toString(){ "$x, $y" }
}

p1 = new Point(x:10, y:2)
p2 = new Point(x:5, y:2)

println p1 + p2
//println p1 - p2
println p1 * 3
println p1 << 3
