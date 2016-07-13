module Throw
  class Double
    MULTIPLIER = 2

    attr_reader :bed_score

    def initialize(bed_value)
      raise ArgumentError.new('Throw must be in range 1..20') if bed_value < 1 || bed_value > 20
      @bed_score = bed_value * MULTIPLIER
    end
  end
end