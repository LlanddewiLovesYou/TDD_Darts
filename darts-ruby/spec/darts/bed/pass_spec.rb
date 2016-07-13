require 'darts'

describe Bed::Pass do
  it 'should have a fixed bed value' do
    expect(Bed::Pass.new.bed_score).to eq(0)
  end
end