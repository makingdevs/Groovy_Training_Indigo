//@groovy.transform.ToString(includeNames=true)
//@groovy.transform.EqualsAndHashCode
//@groovy.transform.TupleConstructor
@groovy.transform.Canonical
class Point3D {
  int x,y,z
  String ref
}

p1 = new Point3D(x:1, y:5, z:8, ref:"origin")
p2 = new Point3D(x:1, y:5, z:8, ref:"origin")
p3 = new Point3D(10)
p3 = new Point3D(10, 40)
p3 = new Point3D(10, 40, 70)
p3 = new Point3D(10, 40, 70, "source")
println p1
println p1 == p2
