require 'darts'

describe Bed::Pass do
  subject { Bed::Pass.new.bed_score }
  it { is_expected.to be_zero }
end