require File.join('models', 'throw', 'miss')

describe Throw::Miss do
  it 'has a score of zero' do
    expect(Throw::Miss.new.bed_score).to eq(0)
  end
end