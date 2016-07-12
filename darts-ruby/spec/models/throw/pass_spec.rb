require File.join('models', 'throw', 'pass')

describe Throw::Pass do
  it 'has a score of zero' do
    expect(Throw::Pass.new.bed_score).to eq(0)
  end
end