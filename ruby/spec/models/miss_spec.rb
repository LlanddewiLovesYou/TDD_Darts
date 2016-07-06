require 'models/miss'

describe Miss do

  let(:miss) { Miss.new }

  it 'has a score of zero' do
    expect(miss.score).to eq(0)
  end
end