import groovyx.gpars.dataflow.Dataflows
import static groovyx.gpars.dataflow.Dataflow.task
 
def flow = new Dataflows()
task { flow.result = flow.x + flow.y }
task { flow.x = 10 }
task { flow.y = 5 }
println flow.result
