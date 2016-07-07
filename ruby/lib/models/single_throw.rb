class SingleThrow
  attr_reader :score

  def initialize(score)
    raise ArgumentError.new('Throw score must be 1..20') if score < 1 || score > 20
    @score = score
  end
end