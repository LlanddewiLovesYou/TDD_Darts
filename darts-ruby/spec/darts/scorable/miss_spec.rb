require 'darts'

describe Scorable::Miss do
  it 'should have a fixed bed value' do
    expect(Scorable::Miss.new.bed_score).to eq(0)
  end
end