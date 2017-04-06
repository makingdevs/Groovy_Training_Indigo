class A {
  def elemento(closure){
    closure()
  }

  def internalCall(){
elemento {
  System.out.println "${this.toString()} ${owner.toString()} ${delegate.toString()}"
    elemento {
      System.out.println "${this.toString()} ${owner.toString()} ${delegate.toString()}"
        elemento {
          System.out.println "${this.toString()} ${owner.toString()} ${delegate.toString()}"
        }
    }
}

  }
}

a = new A()
a.internalCall()
