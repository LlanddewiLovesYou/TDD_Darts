require 'darts'

describe Throw::OuterBullseye do
  it 'should have a fixed bed value' do
    expect(Throw::OuterBullseye.new.bed_score).to eq(25)
  end
end