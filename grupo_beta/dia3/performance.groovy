@Grab(group='org.gperfutils', module='gbench', version='0.4.2-groovy-2.1')
import groovy.transform.CompileStatic

def fibonnacciGroovy(n) { n < 1 ? 1 : fibonnacciGroovy(n-1) + fibonnacciGroovy(n-2) }

int fibonnacciGroovyTipado(int n) { n < 1 ? 1 : fibonnacciGroovyTipado(n-1) + fibonnacciGroovyTipado(n-2) }

@CompileStatic
int fibonnacciGroovyStatic(int n) { n<1 ? 1 : fibonnacciGroovyStatic(n-1)+fibonnacciGroovyStatic(n-2) }

def r = benchmark {
  'Fibonnacci con Groovy dinámico' {
    fibonnacciGroovy(10)
  }
  'Fibonnacci con Groovy optimizado' {
    fibonnacciGroovyTipado(10)
  }
  'Fibonnacci con Groovy compilado estaticamente' {
    fibonnacciGroovyStatic(10)
  }
}
r.prettyPrint()
