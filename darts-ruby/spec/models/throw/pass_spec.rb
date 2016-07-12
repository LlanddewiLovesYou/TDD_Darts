require File.join('models', 'throw', 'pass')

describe Throw::Pass do
  it 'should have a fixed bed value' do
    expect(Throw::Pass.new.bed_score).to eq(0)
  end
end