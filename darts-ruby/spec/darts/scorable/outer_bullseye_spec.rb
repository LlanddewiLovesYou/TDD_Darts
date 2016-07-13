require 'darts'

describe Scorable::OuterBullseye do
  it 'should have a fixed bed value' do
    expect(Scorable::OuterBullseye.new.bed_score).to eq(25)
  end
end