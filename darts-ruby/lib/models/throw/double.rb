module Throw
  class Double
    MULTIPLIER = 2

    attr_reader :score

    def initialize(bed_amount)
      raise ArgumentError.new('Throw must be in range 1..20') if bed_amount < 1 || bed_amount > 20
      @score = bed_amount * MULTIPLIER
    end
  end
end