require File.join('models', 'throw', 'pass')

describe Throw::Pass do
  subject { Throw::Pass.new }

  it 'has a score of zero' do
    expect(subject.score).to eq(0)
  end
end