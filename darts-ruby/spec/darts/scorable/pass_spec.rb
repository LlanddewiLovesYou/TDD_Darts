require 'darts'

describe Scorable::Pass do
  it 'should have a fixed bed value' do
    expect(Scorable::Pass.new.bed_score).to eq(0)
  end
end