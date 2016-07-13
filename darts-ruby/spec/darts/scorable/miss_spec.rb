require 'darts'

describe Throw::Miss do
  it 'should have a fixed bed value' do
    expect(Throw::Miss.new.bed_score).to eq(0)
  end
end