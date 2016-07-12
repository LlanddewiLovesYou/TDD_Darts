module Throw
  class Triple
    MULTIPLIER = 3

    attr_reader :score

    def initialize(bed_amount)
      raise ArgumentError.new('Throw score must be in range 1..20') if bed_amount < 1 || bed_amount > 20
      @score = bed_amount * MULTIPLIER
    end
  end
end