@Grab(group='org.springframework', module='spring-jdbc', version='4.3.7.RELEASE')
import org.springframework.jdbc.core.JdbcTemplate

jdbcTemplate = new JdbcTemplate()
println jdbcTemplate.properties
