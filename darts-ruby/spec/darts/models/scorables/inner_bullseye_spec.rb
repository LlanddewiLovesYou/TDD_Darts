require 'darts'

describe Throw::InnerBullseye do
  it 'should have a fixed bed value' do
    expect(Throw::InnerBullseye.new.bed_score).to eq(50)
  end
end