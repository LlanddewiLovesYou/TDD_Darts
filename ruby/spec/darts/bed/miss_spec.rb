require 'darts'

describe Bed::Miss do
  subject { Bed::Miss.new.bed_score }
  it { is_expected.to be_zero }
end