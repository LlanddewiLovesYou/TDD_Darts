require 'darts'

describe Scorable::InnerBullseye do
  it 'should have a fixed bed value' do
    expect(Scorable::InnerBullseye.new.bed_score).to eq(50)
  end
end