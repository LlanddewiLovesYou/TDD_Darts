class DoubleThrow
  attr_reader :score

  def initialize(score)
    raise ArgumentError.new('Throw must be in range 1..20') if score < 1 || score > 20
    @score = score * 2
  end
end