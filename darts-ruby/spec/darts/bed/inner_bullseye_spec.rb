require 'darts'

describe Bed::InnerBullseye do
  subject { Bed::InnerBullseye.new.bed_score }
  it { is_expected.to eq 50 }
end