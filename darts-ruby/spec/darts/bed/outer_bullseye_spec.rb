require 'darts'

describe Bed::OuterBullseye do
  it 'should have a fixed bed value' do
    expect(Bed::OuterBullseye.new.bed_score).to eq(25)
  end
end