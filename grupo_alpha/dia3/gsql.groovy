@GrabConfig(systemClassLoader=true)
@Grapes([
    @Grab(group='com.zaxxer', module='HikariCP', version='2.6.1'),
@Grab(group='mysql', module='mysql-connector-java', version='5.1.6')
])
import groovy.sql.Sql
import com.zaxxer.hikari.HikariDataSource

HikariDataSource ds = new HikariDataSource();
ds.setJdbcUrl("jdbc:mysql://localhost:3306/issue_tracker");
ds.setUsername("makingdevs");
ds.setPassword("makingdevs");

db = [
  username: "makingdevs",
  password: "makingdevs",
  url: "jdbc:mysql://localhost/issue_tracker",
  driver: "com.mysql.jdbc.Driver"
]

//sql = Sql.newInstance(db.url, db.username, db.password, db.driver)
sql = Sql.newInstance(ds)

sql.execute """
create table if not exists issue(
id integer primary key auto_increment,
description varchar(255),
priority integer,
date_created datetime);
"""

sql.execute """
	insert into issue(description, priority, date_created) values
	('No jala',4, now()),
	('No esta bonito', 3, now()),
	('En mi local si jala', 1, now())
"""

issue1 = ["No se muestran los clientes",1, new Date()-30]

sqlInsert = "insert into issue(description, priority, date_created) values(?,?,?)"
sql.execute sqlInsert, issue1

//sql.eachRow("select * from issue") { row ->
//	println row
//}

dataset = sql.dataSet('issue')

filterIssues = dataset.findAll { row ->
	row.id >= 5 && row.id <=9
}
println filterIssues.sql
filterIssues.each { row ->
	println "${row.description} - ${row[3]}"
}


dataset.add(
	description: "Ultimo issue",
	priority: 10,
  date_created: new Date() - 20
)

counter = sql.firstRow("select count(*) as counter from issue limit 0,1;")['counter']
println "Hay ${counter} registros"
