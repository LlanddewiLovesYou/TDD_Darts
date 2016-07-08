require 'models/miss'

describe Miss do

  subject { Miss.new }

  it 'has a score of zero' do
    expect(subject.score).to eq(0)
  end
end