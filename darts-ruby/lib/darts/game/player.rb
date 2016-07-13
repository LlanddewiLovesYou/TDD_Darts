class Player

  def score
    raise NotImplementedError.new 'Method not implemented'
  end

  def turn(firstThrow, secondThrow, thirdThrow)
    raise NotImplementedError.new 'Method not implemented'
  end

end