require 'darts'

describe Bed::Miss do
  it 'should have a fixed bed value' do
    expect(Bed::Miss.new.bed_score).to eq(0)
  end
end