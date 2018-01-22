import sys 
import spidev

spi = spidev.SpiDev() 
spi.open(0, 0)

r = spi.xfer2([1, 8 + 0 << 4, 0]) 
adcout = ((r[1] & 3) << 8) + r[2]

volts = (adcout * 3.3) / 1024
print (volts)
