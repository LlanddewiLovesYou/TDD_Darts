require File.join('models', 'throw', 'miss')

describe Throw::Miss do

  subject { Throw::Miss.new }

  it 'has a score of zero' do
    expect(subject.bed_score).to eq(0)
  end
end