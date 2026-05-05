object TestRunner {
  def main(args: Array[String]): Unit = {
    val signalcase_1 = Signal(58, 86, 13, 15, 5)
    assert(Policy.score(signalcase_1) == 123)
    assert(Policy.classify(signalcase_1) == "review")
    val signalcase_2 = Signal(70, 74, 27, 14, 12)
    assert(Policy.score(signalcase_2) == 125)
    assert(Policy.classify(signalcase_2) == "review")
    val signalcase_3 = Signal(99, 97, 10, 15, 12)
    assert(Policy.score(signalcase_3) == 253)
    assert(Policy.classify(signalcase_3) == "accept")
  }
}
