class TripleThrow
  attr_reader :score

  def initialize(score)
    raise ArgumentError.new('Throw score must be in range 1..20') if score < 1 || score > 20
    @score = score * 3
  end
end