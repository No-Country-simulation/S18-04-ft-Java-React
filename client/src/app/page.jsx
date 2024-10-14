import Image from 'next/image';
import Link from 'next/link';
import Logo from '/public/images/svg/NoCountry.svg';
import Button from '@/components/Button/Button';

// Normalmente pones el nombre de la carpeta
export default function Home() {
  return (
    <div
      data-testid="root-page"
      className="grid min-h-screen grid-rows-[20px_1fr_20px] items-center justify-items-center bg-primary-300 bg-gradient-bg-radial p-8 pb-20 md:px-14 lg:px-36">
      <main className="row-start-2 flex flex-col items-center gap-8 sm:items-start">
        <div className="grid grid-cols-1 place-content-center items-center gap-4 md:gap-5 lg:max-w-[1000px] lg:grid-cols-2">
          <div className="block w-full">
            <div className="text-center text-2xl font-medium text-white sm:text-left sm:text-3xl">
              Potenciamos
            </div>

            <h1 className="mb-4 flex place-content-center leading-[120%] sm:place-content-start">
              <span className="text-gradient gradient-green-blue-100 text-center text-[44px] font-semibold leading-[120%] sm:text-start sm:text-[64px]">
                Talento sin Experiencia
              </span>
            </h1>
            <p className="mb-2.5 text-center text-base text-[#acacb5] sm:text-left">
              Brindamos un ecosistema que permite ganar experiencia, habilidades interpersonales y
              confianza. <strong>100% gratis, inclusivo y remoto</strong>.
            </p>
            <div className="mt-4 grid grid-rows-2 gap-4">
              <Button
                variant="primary"
                asChild
                className="w-3/4 place-content-center items-center justify-self-center text-sm sm:justify-self-start md:text-base">
                <Link href="https://www.nocountry.tech/simulacion-laboral" target="_blank">
                  Simulación Laboral
                </Link>
              </Button>
              <Button
                variant="secondary"
                asChild
                className="w-3/4 place-content-center items-center justify-self-center text-sm sm:justify-self-start md:text-base">
                <Link href="https://www.nocountry.tech/hackathon" target="_blank">
                  Organiza tu Hackaton
                </Link>
              </Button>
            </div>
          </div>
          <div className="grid grid-cols-1 gap-4 rounded-[30px] border-2 border-[#ffffff1a] bg-[#ffffff0d] px-3 py-7 sm:grid-cols-3 sm:gap-0 md:p-10 lg:grid-cols-1 lg:gap-8">
            <div className="grid w-auto grid-cols-1 items-center justify-self-center">
              <div className="text-center text-[18px] leading-none text-white">
                Talento identificado
              </div>
              <div className="text-gradient gradient-green-blue-100 text-[80px] font-semibold leading-none lg:text-[120px] lg:leading-tight">
                5235
              </div>
              <div className="text-center text-[18px] leading-none text-white">de +20.000</div>
            </div>
            <div className="flex w-full flex-col">
              <div className="flex place-content-end">
                <div className="pb-1 pe-4 text-xs font-medium uppercase text-[#85ffbd]">
                  Validados
                </div>
              </div>

              <div className="flex w-full place-content-between items-center px-4">
                <div className="flex place-content-start items-center">
                  <div className="my-0 text-xs font-medium text-white lg:text-sm">Front-End</div>
                </div>
                <div className="flex place-content-end">
                  <div className="my-0 text-lg font-medium text-white lg:text-xl">+1450</div>
                </div>
              </div>
              <div className="h-px bg-gradient-to-r from-[#0cfca700] to-[#0cfca7] ps-4" />

              <div className="flex w-full place-content-between items-center px-4">
                <div className="flex place-content-start items-center">
                  <div className="my-0 text-xs font-medium text-white lg:text-sm">Back-End</div>
                </div>
                <div className="flex place-content-end">
                  <div className="my-0 text-lg font-medium text-white lg:text-xl">+1290</div>
                </div>
              </div>
              <div className="h-px bg-gradient-to-r from-[#0cfca700] to-[#0cfca7] ps-4" />

              <div className="flex w-full place-content-between items-center px-4">
                <div className="flex place-content-start items-center">
                  <div className="my-0 text-xs font-medium text-white lg:text-sm">
                    UX/UI Designer
                  </div>
                </div>
                <div className="flex place-content-end">
                  <div className="my-0 text-lg font-medium text-white lg:text-xl">+890</div>
                </div>
              </div>
              <div className="h-px bg-gradient-to-r from-[#0cfca700] to-[#0cfca7] ps-4" />

              <div className="flex w-full place-content-between items-center px-4">
                <div className="flex place-content-start items-center">
                  <div className="my-0 text-xs font-medium text-white lg:text-sm">
                    Data Analitycs
                  </div>
                </div>
                <div className="flex place-content-end">
                  <div className="my-0 text-lg font-medium text-white lg:text-xl">+320</div>
                </div>
              </div>
              <div className="h-px bg-gradient-to-r from-[#0cfca700] to-[#0cfca7] ps-4" />

              <div className="flex w-full place-content-between items-center px-4">
                <div className="flex place-content-start items-center">
                  <div className="my-0 text-xs font-medium text-white lg:text-sm">
                    Data Engineer
                  </div>
                </div>
                <div className="flex place-content-end">
                  <div className="my-0 text-lg font-medium text-white lg:text-xl">+125</div>
                </div>
              </div>
              <div className="h-px bg-gradient-to-r from-[#0cfca700] to-[#0cfca7] ps-4" />

              <div className="flex w-full place-content-between items-center px-4">
                <div className="flex place-content-start items-center">
                  <div className="my-0 text-xs font-medium text-white lg:text-sm">
                    Project Manager
                  </div>
                </div>
                <div className="flex place-content-end">
                  <div className="my-0 text-lg font-medium text-white lg:text-xl">+240</div>
                </div>
              </div>

              <div className="h-px bg-gradient-to-r from-[#0cfca700] to-[#0cfca7] ps-4" />

              <div className="flex w-full place-content-between items-center px-4">
                <div className="flex place-content-start items-center">
                  <div className="my-0 text-xs font-medium text-white lg:text-sm">QA Tester</div>
                </div>
                <div className="flex place-content-end">
                  <div className="my-0 text-lg font-medium text-white lg:text-xl">+340</div>
                </div>
              </div>
            </div>
            <div className="flex place-content-center items-center">
              <div className="text-gradient gradient-green-blue-200 text-center text-2xl font-bold uppercase">
                +20 roles tech
              </div>
            </div>
          </div>
          <div className="mx-auto mt-[29px] flex max-w-[900px] flex-col place-content-center items-center lg:col-span-2">
            <Link href="/" className="block w-full">
              <Image
                width={144}
                height={32}
                className="h-8 w-36 justify-self-center"
                src={Logo}
                alt="logo"
              />
            </Link>
          </div>
        </div>
      </main>
    </div>
  );
}
