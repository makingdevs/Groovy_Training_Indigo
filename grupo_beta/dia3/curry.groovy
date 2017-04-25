def configurator = { format, filter, line ->
   filter(line) ?  format(line) : null
}
def appender = { config, append, line ->
    def out = config(line)
      if (out) append(out)
}

def dateFormatter   = { line -> "${new Date()}: $line" }
def debugFilter     = { line -> line.contains('debug') }
def consoleAppender = { line -> println line }

def myConf = configurator.curry(dateFormatter, debugFilter)
def myLog  = appender.curry(myConf, consoleAppender)
myLog('aquí hay un mensaje de debug')
myLog('este mensaje no se va a mostrar')

