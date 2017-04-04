class FormatUtil {
  static toFormat(numero){
    if(numero.size() == 10)
      return "${numero[0..2]} - ${numero[3..5]} - ${numero[6..9]}"
  }
}

use(FormatUtil){
  println "5518503073".toFormat()
  println new StringBuffer("1234567890").toFormat()
}

try {
  "1234567890".toFormat()
}catch(e){
  println e.message
}
