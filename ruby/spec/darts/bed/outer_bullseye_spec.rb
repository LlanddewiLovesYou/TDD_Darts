describe Bed::OuterBullseye do
  subject { Bed::OuterBullseye.new.bed_score }
  it { is_expected.to eq 25 }
end