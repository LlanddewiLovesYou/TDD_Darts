require 'models/pass'

describe Pass do
  subject { Pass.new }

  it 'has a score of zero' do
    expect(subject.score).to eq(0)
  end
end