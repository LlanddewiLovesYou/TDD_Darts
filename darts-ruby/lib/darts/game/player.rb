class Player

  def score
    raise NotImplementedError.new 'Method not implemented'
  end

  def turn(first_throw, second_throw, third_throw)
    raise NotImplementedError.new 'Method not implemented'
  end

end