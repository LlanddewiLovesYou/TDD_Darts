require 'darts'

describe Bed::InnerBullseye do
  it 'should have a fixed bed value' do
    expect(Bed::InnerBullseye.new.bed_score).to eq(50)
  end
end