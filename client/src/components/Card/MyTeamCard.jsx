import Image from 'next/image';
import Attendance from '/public/images/svg/EditIcon.svg';

export const MyTeamCard = ({ name, rol, tl }) => {
  return (
    <div className="mb-5 mt-2 grid grid-cols-2 items-center border border-[#14c7d1] p-5 leading-5">
      <div className="">{name}</div>
      <div className="flex justify-between px-3">
        {rol}
        {tl && (
          <button>
            <Image width={20} height={20} src={Attendance} alt="Attendance" />
          </button>
        )}
      </div>
    </div>
  );
};
